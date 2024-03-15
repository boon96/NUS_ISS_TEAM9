import React from "react";

export const HotelBooking = () => {
    return (
        <section className="m-8">
            <h1> welcome to hotel booking</h1>
            <div className="md-form md-outline input-with-post-icon datepicker">
                <input placeholder="Select date" type="date" id="example" className="form-control"/>
            </div>
        </section>
    )
}