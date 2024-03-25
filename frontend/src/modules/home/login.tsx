import { log } from "console";
import React, { useState } from "react";
import { testlogin } from "./login.reducer";
import { Navigate, useNavigate } from "react-router-dom";
import { AppDispatch } from "src/config/store";
import { Storage } from 'react-jhipster';
// import { useAppDispatch } from 'react-redux';

export const HotelHome = () => {

    //to call api
    const dispatch = AppDispatch();
    //to navigate to other page
    const navigate = useNavigate();

    const [loginForm, setLoginForm] = useState({
        // name: '',
        emailAddress: '',
        phoneNumber: 0,
    });

    const handleChange = (event) =>{
        console.log(event);
        console.log(event.target.value)
        // console.log(event);
        const {id,value} = event.target; 
               setLoginForm({
            ...loginForm,
          [id]: value  
        })
    }

    const onClick = (event) =>{
        console.log(loginForm);
        try{
            const results = dispatch(testlogin(loginForm)).then(result =>{
                console.log(result);
                // if correct result
                //for testing only
                Storage.session.set("customer", result.payload['data']);

                navigate('/');
            })
        }
        catch(error){
            console.log("error onclick" + error);
        }
    };
    return (
        <div>
            {/* <div className="col-md-6">
                <label className="form-label" htmlFor="name">
                    Enter Username:
                </label>
                <input
                type="text"
                id="name"
                name="name"
                className="form-control"
                onChange={handleChange} />
            </div> */}

            <div className="col-md-6">
                <label className="form-label" htmlFor="emailAddress">
                    Enter Email Address:
                </label>
                <input
                type="text"
                id="emailAddress"
                name="emailAddress"
                className="form-control"
                onChange={handleChange} />
            </div>
            <div className="col-md-6">
                <label className="form-label" htmlFor="phoneNumber">
                    Enter Phone:
                </label>
                <input
                type="number"
                id="phoneNumber"
                name="phoneNumber"
                className="form-control"
                onChange={handleChange} />
            </div>
            <label> result of username {loginForm.emailAddress}</label>


            <button type="button" onClick={onClick}>Submit Button</button>
        </div>
        
    )
}
export default HotelHome;