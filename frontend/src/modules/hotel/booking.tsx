import React, { useEffect, useState } from "react";
import { Card, Button, Checkbox, Form, type FormProps, Input, DatePicker, InputNumber, notification } from 'antd';
import moment from 'moment';
import { useNavigate } from "react-router-dom";
import { AppDispatch } from "src/config/store";
import { Storage } from 'react-jhipster';
import { roomSearch } from "./hotel.reducer";
import HotelHeader from "../shared/UI/hotelHeader";

export const HotelBooking = () => {
    const { RangePicker } = DatePicker;
    //to call api
    const dispatch = AppDispatch();
    //to navigate to other page
    const navigate = useNavigate();


    const [dates1, setDates] = useState([]);


    interface FormValues {
        startDate?: Date;
        endDate?: Date;
        // startDate?: String,
        // endDate?: String;
    }

    // const [formValues, setFormValues] = useState<FormValues>({startDate: '', endDate: ''});
    const [formValues, setFormValues] = useState<FormValues>({});

    type FieldType = {
        dates?: [moment.Moment[], moment.Moment[]];
        // adults?: number;
    };

    // FOR DATE FORMAT
    // const onFinish: FormProps<FieldType>["onFinish"] = (values) => {
    // FOR STRING FORMAT
    const onFinish = (values: FormValues) => {
        // Access values.startDate and values.endDate here
        console.log('Form values:', values);
        // console.log('Success:', values);
        console.log("dates:", dates1);
        // const { adults } = values;

        // Extract start and end dates from the RangePicker value
        // const startDate = dates1[0].format('DD-MM-YYYY');
        // const endDate = dates1[1].format('DD-MM-YYYY');

        // // Use the dates for API query search
        // console.log('Start Date:', startDate);
        // console.log('End Date:', endDate);
        console.log(formValues);
        // setFormValues(startDate,endDate);

        // Make Axios request here
        try {
            // let result = await dispatch(findFmsByPSPNoSubNoHsCode(formValues));
            const results = dispatch(roomSearch(formValues)).then(result => {
                console.log('results: ', result.payload);
                // if status 400 do something,
                // if status 400 navigate ( storage session etc)

            });
        } catch (error) {
            console.log('Error status code:', error.response?.status); // Log the error status code
            console.log('Error data:', error.response); // Log the error response body
            console.log('failed result');
        }
        Storage.session.set('checkInDate', formValues.startDate);
        Storage.session.set('checkOutDate', formValues.endDate);
        Storage.session.set('searchedForm', formValues);
        // Storage.session.set('adults',adults);
        navigate('/hotel');
    };

    const onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    return (
        <section className="m-8">
            <HotelHeader/>

            <Card title="Book your stay here" style={{ width: 600, margin: 'auto' }}>
                <Form
                    name="basic"
                    labelCol={{ span: 8 }}
                    wrapperCol={{ span: 16 }}
                    style={{ maxWidth: 600 }}
                    initialValues={{ remember: true }}
                    onFinish={onFinish}
                    onFinishFailed={onFinishFailed}
                    autoComplete="off"
                >
                    {/* for date format */}
                    {/* <Form.Item<FieldType> */}
                    <Form.Item
                        label="Check-in/Check-out Dates"
                        name="dates"
                        rules={[{ required: true, message: 'Please select check-in and check-out dates!' }]}
                    >
                        <RangePicker
                            format="DD-MM-YYYY"
                            disabledDate={(current) => current && current < moment().endOf('day')}
                            showTime={false}
                            // onChange={(dates) => {
                            //     if (dates && dates.length === 2) {
                            //     //   const startDate = dates[0].format('DD-MM-YYYY');
                            //     const startDate = dates[0];
                            //     const endDate = dates[1];
                            //     //   const endDate = dates[1].format('DD-MM-YYYY');
                            //       setFormValues({ startDate, endDate });
                            //     }
                            //   }}
                            //for date format
                            onChange={(dates) => {
                                if (dates && dates.length === 2) {
                                    setFormValues({ startDate: dates[0].toDate(), endDate: dates[1].toDate() });
                                }
                            }}

                        />
                    </Form.Item>
                    {/* <Form.Item<FieldType>
                        label="Number of Adults"
                        name="adults"
                        rules={[{ required: true, message: 'Please input number of adults!' }]}
                    >
                        <InputNumber style={{ width: '100%' }} min={1} />
                    </Form.Item> */}
                    <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
                        <Button type="primary" htmlType="submit">
                            Submit
                        </Button>
                    </Form.Item>
                </Form>
            </Card>
        </section>
    )
}