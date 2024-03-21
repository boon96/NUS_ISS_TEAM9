import {combineReducers} from '@reduxjs/toolkit';
import { HomeStateSlice } from 'src/modules/home/login.reducer';
import { HotelStateSlice } from 'src/modules/hotel/hotel.reducer';
import getStore from './store';

const rootReducer = combineReducers({

    // Add more reducers as needed
    HomeStateSlice: HomeStateSlice.reducer,
    HotelStateSlice: HotelStateSlice.reducer,

  });

export default rootReducer;