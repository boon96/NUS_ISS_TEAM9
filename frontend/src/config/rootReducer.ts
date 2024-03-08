import {combineReducers} from '@reduxjs/toolkit';
import { HomeStateSlice } from 'src/modules/home/login.reducer';

const rootReducer = combineReducers({

    // Add more reducers as needed
    HomeStateSlice: HomeStateSlice,
  });

export default rootReducer;