import { log } from "console";
import React, { useState } from "react";
import { testlogin } from "./login.reducer";
import { Navigate, useNavigate } from "react-router-dom";
import { AppDispatch } from "src/config/store";
import { Storage } from 'react-jhipster';
// import { useAppDispatch } from 'react-redux';
import { Form, Input, Button, Card, notification } from 'antd';
import HotelHeader from "../shared/UI/hotelHeader";

export const HotelHome = () => {

    //to call api
    const dispatch = AppDispatch();
    //to navigate to other page
    const navigate = useNavigate();
    const [form] = Form.useForm();

    const onFinish = async (values) => {
        console.log('Received values:', values);
        try {
            let result = await dispatch(testlogin(values));
            if (result.payload == null || result.payload == undefined || result.payload == "") {
                console.log("no data found");
                return;
            } else {
                Storage.session.set("customer", result.payload['data']);
                navigate('/');
                window.location.reload();
                // notification.success({
                //     message: 'Logged In',
                //     description: 'Hello ' + result.payload['data']['name'],
                // });
            }
            
        }
        catch (error) {
            console.log("error onclick" + error);
        }
    };
    return (
        <section className="m-8">
        <HotelHeader/>

        <Card title="Sign In" style={{ width: 700, margin: 'auto' }}>

            <Form
                form={form}
                onFinish={onFinish}
                labelCol={{ span: 6 }}
                wrapperCol={{ span: 18 }}
            >
                <Form.Item
                    label="Enter Email Address:"
                    name="emailAddress"
                    rules={[{ required: true, message: 'Please enter your email address!' }]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    label="Enter Phone:"
                    name="phoneNumber"
                    rules={[{ required: true, message: 'Please enter your phone number!' }]}
                >
                    <Input type="number" />
                </Form.Item>

                <Form.Item wrapperCol={{ offset: 6, span: 18 }}>
                    <Button type="primary" htmlType="submit">
                        Login
                    </Button>
                </Form.Item>
            </Form>

        </Card>
        </section>
    )
}
export default HotelHome;