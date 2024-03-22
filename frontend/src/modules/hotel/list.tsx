import "./searchItem.css";
import { useLocation } from "react-router-dom";
import React, { useState } from "react";
import { format } from "date-fns";
import { DateRange } from "react-date-range";
import SearchItem from "./searchedItem";
import { Storage } from 'react-jhipster';
import moment, { Moment } from 'moment';
import dayjs, { Dayjs } from 'dayjs';
import { DatePicker, InputNumber, Button, Form } from 'antd';
import { reservationBooking } from "./hotel.reducer";
import { AppDispatch } from "src/config/store";

const List = () => {
    const { RangePicker } = DatePicker;
        //to call api
        const dispatch = AppDispatch();
    const checkInDate = Storage.session.get('checkInDate');
    const checkOutDate = Storage.session.get('checkOutDate');
    const searchedForm = Storage.session.get('searchedForm')
    console.log("formvalues: " , searchedForm);
    
    interface FormValues {
        checkInDate?: Date;
        checkOutDate?: Date;
        minPrice?: number;
        maxPrice?: number;
      }

    interface IReservationForm{
        checkInDate?: Date;
        checkOutDate?: Date;
        totalPrice? : number;
        customerId?: number;
        roomId?:  number;
    }

    const[reservationForm, setReservationForm] = useState<IReservationForm>({
        checkInDate: searchedForm.startDate,
        checkOutDate: searchedForm.endDate,
    }); 

    const [formValues, setFormValues] = useState<FormValues>({
        checkInDate: searchedForm.startDate,
        checkOutDate: searchedForm.endDate,
    });
    // const defaultStartDate = moment(searchedForm.startDate, 'DD-MM-YYYY').toDate(); // Convert Moment.js object to Date object
    // const defaultEndDate = moment(searchedForm.endDate, 'DD-MM-YYYY').toDate(); // Convert Moment.js object to Date object

    console.log("defaultStartDate: ", searchedForm.startDate);
    const defaultStartDateDayjs = dayjs(searchedForm.startDate); // Convert Date object to Day.js object
    const defaultEndDateDayjs = dayjs(searchedForm.endDate); // Convert Date object to Day.js object

    const [dateRange, setDateRange] = useState([defaultStartDateDayjs, defaultEndDateDayjs]);
    // const [dateRange, setDateRange] = useState(testing);
    console.log(dateRange);

    const handleDateChange = (dates) => {
        // setDateRange(dates); // Update the date range state whenever the user selects new dates
            // if (dates && dates.length === 2) {
            //   const startDate = dates[0].format('DD-MM-YYYY');
            //   const endDate = dates[1].format('DD-MM-YYYY');
            //   setFormValues({ startDate, endDate });
            // }
                if (dates && dates.length === 2) {
                  setFormValues({ checkInDate: dates[0].toDate(), checkOutDate: dates[1].toDate() });
                }
    };

    const handlePriceChange = (fieldName) => (value) => {
        setFormValues(prevState => ({
            ...prevState,
            [fieldName]: value
        }));
    };

    const handleSubmit = (values) => {
        console.log("Form values:", formValues); // Form values will contain the selected date range
        console.log("Selected date range:", dateRange); // You can also directly log the state variable directly

        //check in and checkout date
        //total price
        //storage session customerid.

        // axios to search for hotel again
    
        const totalPrice = 300;
        console.log("before ", reservationForm);

        setReservationForm(formValues);
        //MOCK DATA 
        const customerId = 1;
        const roomId = 2;
        console.log("after", reservationForm);
        const updatedReservationForm: IReservationForm = {
            ...reservationForm, // Spread the existing form values
            totalPrice: totalPrice, // Set the totalPrice property
            customerId: customerId,
            roomId: roomId
        };
        setReservationForm(updatedReservationForm); // Update the reservationForm state


        console.log("reservation form: ", reservationForm); // Log the updated reservationForm

        try {
            // let result = await dispatch(findFmsByPSPNoSubNoHsCode(formValues));
            const results = dispatch(reservationBooking(reservationForm)).then(result => {
                console.log('results: ', result.payload);
                // if status 400 do something,
                // if status 400 navigate ( storage session etc)

            });
        } catch (error) {
            console.log('Error status code:', error.response?.status); // Log the error status code
            console.log('Error data:', error.response); // Log the error response body
            console.log('failed result');
        }

    };

    const handleReservation = (values) => {
        console.log(formValues);
        const totalPrice = 300;
        console.log("before ", reservationForm);

        setReservationForm(formValues);
        //MOCK DATA 
        const customerId = 1;
        const roomId = 2;
        console.log("after", reservationForm);
        const updatedReservationForm: IReservationForm = {
            ...reservationForm, // Spread the existing form values
            totalPrice: totalPrice, // Set the totalPrice property
            customerId: customerId,
            roomId: roomId
        };
        setReservationForm(updatedReservationForm); // Update the reservationForm state


        console.log("reservation form: ", reservationForm); // Log the updated reservationForm
    };

    return (
        <div>
            <div className="listContainer">
                <div className="listWrapper">
                    <div className="listSearch">
                        <h1 className="lsTitle">Search</h1>
                        <div className="lsItem">
                        <label>Check-in/Check-out Date</label>
                            <Form onFinish={handleSubmit}>
                                <Form.Item>
                                    <RangePicker
                                        format="DD-MM-YYYY"
                                        disabledDate={(current) => current && current < moment().endOf('day')}
                                        showTime={false}
                                        // value={[defaultStartDateDayjs,defaultEndDateDayjs]}
                                        // defaultPickerValue={[defaultStartDateDayjs, defaultEndDateDayjs]}
                                        defaultValue={[defaultStartDateDayjs,defaultEndDateDayjs]}
                                        onChange={handleDateChange} // Call handleDateChange on date selection change
                                    />
                                </Form.Item>
                                <div className="lsItem">
                                    <label>Options</label>
                                    <div className="lsOptions">
                                        <div className="lsOptionItem">
                                            <span className="lsOptionText">
                                                Min price <small>per night</small>
                                            </span>
                                            <InputNumber 
                                            value={formValues.minPrice}
                                            onChange={handlePriceChange('minPrice')} />
                                        </div>
                                        <div className="lsOptionItem">
                                            <span className="lsOptionText">
                                                Max price <small>per night</small>
                                            </span>
                                            <InputNumber 
                                             value={formValues.maxPrice}
                                             onChange={handlePriceChange('maxPrice')}/>
                                        </div>
                                    </div>
                                </div>
                                <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
                                    <Button type="primary" htmlType="submit">
                                        Search
                                    </Button>
                                </Form.Item>
                            </Form>
                        </div>
                    </div>
                    <div className="listResult">
                        <SearchItem price={10} dates={formValues}
                        handleSubmit={handleSubmit} handleReservation={handleReservation}/>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default List;