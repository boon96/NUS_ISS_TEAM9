import React, { useState } from "react";
import { Form, Input, Button, Card, notification } from 'antd';
import HotelHeader from "../shared/UI/hotelHeader";
import { searchBooking } from "./hotel.reducer";
import { AppDispatch } from "src/config/store";
import { useNavigate } from "react-router-dom";

export const SearchBooking = () => {
    const dispatch = AppDispatch();
    //to navigate to other page
    const navigate = useNavigate();

    const [form] = Form.useForm(); // Form instance
    const [loading, setLoading] = useState(false); // State to manage loading state

    const handleSearch = async () => {
        try {
            const values = await form.validateFields(); // Validate form fields
            setLoading(true); // Set loading state while searching
            const bookingId = Number(values.bookingId);
            // Call the booking service function to search for booking by ID
            const result = await dispatch(searchBooking(bookingId));

            // Handle the response (e.g., display booking details)
            console.log("Booking found:", result);
            if (result.payload == '' || result.payload == undefined || result.payload == null) {
                notification.warning({
                    message: 'No Booking Found',
                    description: 'No booking found with ID ' + values.bookingId + '.',
                });
            } else {
                notification.success({
                    message: 'Booking Found',
                    description: 'Booking with ID ' + values.bookingId + ' found.',
                });
                const data = result.payload['data']

                navigate('/summary', { state: { data: data, modify: true } })
            }

            // Reset the form
            form.resetFields();
        } catch (error) {
            // Handle form validation error
            console.error("Validation error:", error);
            notification.error({
                message: 'Validation Error',
                description: 'Please enter the booking ID.',
            });
        } finally {
            setLoading(false); // Reset loading state
        }
    };

    return (
        <section className="m-8">
            <HotelHeader />
            <Card title="Search Booking" style={{ width: 700, margin: 'auto' }}>
                <Form form={form} layout="vertical">
                    <Form.Item
                        name="bookingId"
                        label="Booking ID"
                        rules={[{ required: true, message: 'Please enter the booking ID.' }]}
                    >
                        <Input />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" loading={loading} onClick={handleSearch}>Search</Button>
                    </Form.Item>
                </Form>
            </Card>
        </section>
    );
}
export default SearchBooking;