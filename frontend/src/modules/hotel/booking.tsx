import React, { useState } from "react";
import { Card, Button, Checkbox, Form, type FormProps, Input, DatePicker, InputNumber } from 'antd';
import moment from 'moment';
import { Navigate, useNavigate } from "react-router-dom";
import { AppDispatch } from "src/config/store";
import { Storage } from 'react-jhipster';

export const HotelBooking = () => {
    const { RangePicker } = DatePicker;
    //to call api
    const dispatch = AppDispatch();
    //to navigate to other page
    const navigate = useNavigate();

    const [dates, setDates] = useState([]);

    type FieldType = {
        // dates?: moment.Moment[];
        adults?: number;
    };

    const onFinish: FormProps<FieldType>["onFinish"] = (values) => {
        console.log('Success:', values);
        const { adults } = values;
    
    // Extract start and end dates from the RangePicker value
    const startDate = dates[0].format('DD-MM-YYYY');
    const endDate = dates[1].format('DD-MM-YYYY');

    // Use the dates for API query search
    console.log('Start Date:', startDate);
    console.log('End Date:', endDate);

            // Make Axios request here
        // axios.post('YOUR_API_ENDPOINT', values)
        //   .then(response => {
        //     console.log('Server response:', response.data);
        //     // Handle successful response
        //   })
        //   .catch(error => {
        //     console.error('Error:', error);
        //     // Handle error
        //   });
    Storage.session.set('checkInDate',startDate);
    Storage.session.set('checkOutDate', endDate);
    Storage.session.set('test', dates);
    Storage.session.set('adults',adults);
    navigate('/hotel');
    };

    const onFinishFailed: FormProps<FieldType>["onFinishFailed"] = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    return (
        <section className="m-8">
            <div className="d-flex align-items-center justify-content-center">
                <h1>ABC HOTEL</h1>
            </div>

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
                    <Form.Item<FieldType>
                        label="Check-in/Check-out Dates"
                        // name="dates"
                        rules={[{ required: true, message: 'Please select check-in and check-out dates!' }]}
                    >
                        <RangePicker
                            format="YYYY-MM-DD"
                            disabledDate={(current) => current && current < moment().endOf('day')}
                            showTime={false}
                            onChange={(values) =>{
                                setDates(values);
                            } }
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