import {combineReducers} from '@reduxjs/toolkit';
import { HomeStateSlice } from 'src/modules/home/login.reducer';
import getStore from './store';

const rootReducer = combineReducers({

    // Add more reducers as needed
    HomeStateSlice: HomeStateSlice.reducer,
  });

export default rootReducer;