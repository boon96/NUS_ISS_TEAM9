import { log } from "console";
import React, { useState } from "react";
import { testlogin } from "./login.reducer";
import { Navigate, useNavigate } from "react-router-dom";
import { AppDispatch } from "src/config/store";
// import { useAppDispatch } from 'react-redux';

export const HotelHome = () => {

    //to call api
    const dispatch = AppDispatch();
    //to navigate to other page
    const navigate = useNavigate();

    const [loginForm, setLoginForm] = useState({
        userName: '',
        password: '',
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
                navigate('/bookings',{state: {result}});
            })
        }
        catch(error){
            console.log("error onclick" + error);
        }
    };
    return (
        <div>
            <div className="col-md-6">
                <label className="form-label" htmlFor="userName">
                    Enter Username:
                </label>
                <input
                type="text"
                id="userName"
                name="userName"
                className="form-control"
                onChange={handleChange} />
            </div>

            <div className="col-md-6">
                <label className="form-label" htmlFor="password">
                    Enter Password:
                </label>
                <input
                type="text"
                id="password"
                name="password"
                className="form-control"
                onChange={handleChange} />
            </div>
            <label> result of username {loginForm.userName}</label>


            <button type="button" onClick={onClick}>Submit Button</button>
        </div>
        
    )
}
export default HotelHome;