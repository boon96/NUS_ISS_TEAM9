import React from "react";
import { Route } from 'react-router-dom';
import HotelHome from "./modules/home/login";

const AppRoutes = () => {
    return (
        <>
            <Route path="/" element={<HotelHome />} />
        </>
    );
};

export default AppRoutes;