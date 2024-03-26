import React from "react";
import SummaryPage from "../shared/UI/summary";
import { useLocation, useNavigate } from 'react-router-dom';


export const SummaryResult = () =>{
    const location = useLocation();
    const navigate = useNavigate();
    const result = location.state?.data;
    const isModify = location.state?.modify;
    console.log("summary result");
    console.log(isModify);

    console.log(result);
    return(
        <SummaryPage data={result} modify={isModify}/>
    )
}
export default SummaryResult;