import React, { useState } from "react";
import HotelHeader from "./hotelHeader";
import { Card, Button, Form, notification } from 'antd';
import { useLocation, useNavigate } from 'react-router-dom';
import { Storage } from 'react-jhipster';
import ConfirmationModal from "./reservationPopup";
import { deleteBooking } from "src/modules/hotel/hotel.reducer";
import { AppDispatch } from "src/config/store";

//this is a reusable Page
export const SummaryPage = (props) => {
    const dispatch = AppDispatch();
    const navigate = useNavigate();
    const [isConfirmationVisible, setIsConfirmationVisible] = useState(false);

    const formatDate = (dateString) => {
        const date = new Date(dateString);

        const formattedDate = date.toLocaleDateString('en-GB', {
            day: '2-digit',
            month: '2-digit',
            year: '2-digit'
        });

        return formattedDate;
    }

    const checkInDate = formatDate(props.data.checkInDate);
    const checkOutDate = formatDate(props.data.checkOutDate);

    const handleHomeButtonClick = () => {
        navigate('/'); // Navigate to the home page
    }

    const handlePrintButtonClick = () => {
        window.print(); // Print the current page
    }

    const handleDeleteButtonClick = () => {
        setIsConfirmationVisible(true);
    }

    const handleConfirmDelete = async () => {

        // api to call for delete
        try {

            const result = await dispatch(deleteBooking(props.data.bookId));

            // Handle the response (e.g., display booking details)
            console.log("delete result:", result);
            if (result.payload['status'] == 200) {
                notification.success({
                    message: 'Booking Deleted',
                    description: 'Reservation with ID ' + props.data.bookId + ' has been Deleted.',
                });
            } else {
                notification.warning({
                    message: 'Failed to delete booking',
                    description: 'Error occur for ' + props.data.bookId + '. Please email us with your booking Id.',
                });
            }
            navigate('/search');
        } catch (e) {
            console.log(e);
        }
        setIsConfirmationVisible(false); // Close the confirmation modal after deletion
    };

    const handleCancelDelete = () => {
        setIsConfirmationVisible(false); // Close the confirmation modal
    };

    return (
        <section className="m-8">
            <HotelHeader />
            <Card title="Booking Summary" style={{ width: 600, margin: 'auto' }}>
                <p><strong>Check-in Date:</strong> {checkInDate}</p>
                <p><strong>Check-out Date:</strong> {checkOutDate}</p>
                <p><strong>Booking Reference:</strong> {props.data.bookId}</p>
                <p><strong>Guest Name:</strong> {props.data.name}</p>
                <p><strong>Email:</strong> {props.data.emailAddress}</p>
                <p><strong>Phone:</strong> {props.data.phoneNumber}</p>
                <p><strong>Total Price:</strong> {props.data.totalPrice}</p>
                <div style={{ marginTop: '20px' }}>
                    <Button type="primary" onClick={handleHomeButtonClick}>Home</Button>
                    <Button style={{ marginLeft: '10px' }} onClick={handlePrintButtonClick}>Print</Button>
                    {props.modify && (
                        <><Button
                            style={{ marginLeft: '10px' }}
                            danger
                            onClick={handleDeleteButtonClick}
                        >
                            Delete Booking
                        </Button><ConfirmationModal
                                isVisible={isConfirmationVisible}
                                onConfirm={handleConfirmDelete}
                                onCancel={handleCancelDelete}
                                message="Are you sure you want to delete this reservation?" /></>
                    )}
                </div>
            </Card>
        </section>
    )

}

export default SummaryPage;