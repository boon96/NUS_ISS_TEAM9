import React from "react";
import { Card, Button, Checkbox, Form, type FormProps, Input, DatePicker, InputNumber, notification } from 'antd';
import HotelHeader from "../shared/UI/hotelHeader";
import { useNavigate } from "react-router-dom";
import { AppDispatch } from "src/config/store";
import { createAccount } from "./login.reducer";

export const CreateAccount = () => {
        //to call api
        const dispatch = AppDispatch();
        //to navigate to other page
        const navigate = useNavigate();

    interface CreationForm {
        name?: String;
        emailAddress?: String;
        phoneNumber?: number;
        // startDate?: String,
        // endDate?: String;
    }


    const onFinish = async(values: CreationForm) => {
        console.log(values);
        try {
            // let result = await dispatch(findFmsByPSPNoSubNoHsCode(formValues));
            const result = await dispatch(createAccount(values));

            if (result.payload) {
                // Show a success notification to the user
                navigate('/login');
                notification.success({
                    message: 'Account Created',
                    description: 'Your account has been created successfully. Please sign in to access your account.',
                });
            } else {
                notification.error({
                    message: 'Account Creation Failed',
                    description: 'Failed to create your account. Please try again later.',
                });
            }
        } catch (error) {
            console.log('Error status code:', error.response?.status); // Log the error status code
            console.log('Error data:', error.response); // Log the error response body
            console.log('failed result');
            notification.error({
                message: 'Account Creation Failed',
                description: 'Failed to create your account. Please try again later.',
            });
        }
    }

    const onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };


    return (
        <section className="m-8">
            <HotelHeader/>

            <Card title="Account Creation" style={{ width: 600, margin: 'auto' }}>
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
                    <Form.Item<CreationForm>
                        label="Name"
                        name="name"
                        rules={[{ required: true, message: 'Please input your Name!' }]}
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item<CreationForm>
                        label="Email Address"
                        name="emailAddress"
                        rules={[{ required: true, message: 'Please input your Email Address!' }]}
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item<CreationForm>
                        label="Phone Number"
                        name="phoneNumber"
                        rules={[{ required: true, message: 'Please enter your Phone Number!' },
                        {
                            pattern: /^[0-9]*$/, // Regular expression to match exactly 8 digits
                            message: 'Please enter a valid phone number!',
                        },]}
                    >
                        <Input />
                    </Form.Item>
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
export default CreateAccount;