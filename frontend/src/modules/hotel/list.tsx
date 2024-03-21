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

const List = () => {
    const { RangePicker } = DatePicker;
    const checkInDate = Storage.session.get('checkInDate');
    const checkOutDate = Storage.session.get('checkOutDate');
    const searchedForm = Storage.session.get('searchedForm')
    console.log("formvalues: " , searchedForm);
    
    interface FormValues {
        // startDate?: Date;
        // endDate?: Date;
        startDate?: String,
        endDate?: String;
        minPrice?: number;
        maxPrice?: number;
      }


    const [formValues, setFormValues] = useState<FormValues>({
        startDate: searchedForm.startDate,
        endDate: searchedForm.endDate,
    });
    const defaultStartDate = moment(searchedForm.startDate, 'DD-MM-YYYY').toDate(); // Convert Moment.js object to Date object
    const defaultEndDate = moment(searchedForm.endDate, 'DD-MM-YYYY').toDate(); // Convert Moment.js object to Date object

    console.log("defaultStartDate: ", defaultStartDate);
    const defaultStartDateDayjs = dayjs(defaultStartDate); // Convert Date object to Day.js object
    const defaultEndDateDayjs = dayjs(defaultEndDate); // Convert Date object to Day.js object

    const [dateRange, setDateRange] = useState([defaultStartDateDayjs, defaultEndDateDayjs]);
    // const [dateRange, setDateRange] = useState(testing);
    console.log(dateRange);

    const handleDateChange = (dates) => {
        // setDateRange(dates); // Update the date range state whenever the user selects new dates
            if (dates && dates.length === 2) {
              const startDate = dates[0].format('DD-MM-YYYY');
              const endDate = dates[1].format('DD-MM-YYYY');
              setFormValues({ startDate, endDate });
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

        // axios to search for hotel again
        
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
                                        value={[defaultStartDateDayjs,defaultEndDateDayjs]}
                                        // defaultPickerValue={[defaultStartDateDayjs, defaultEndDateDayjs]}
                                        // initialValues={[defaultStartDateDayjs,defaultEndDateDayjs]}
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
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                        <SearchItem />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default List;