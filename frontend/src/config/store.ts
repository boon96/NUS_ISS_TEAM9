import { configureStore } from '@reduxjs/toolkit';
import rootReducer from './rootReducer';
import { useDispatch } from 'react-redux';

const store = configureStore({
  reducer: rootReducer,
  // Additional middleware and configuration if needed
});

const getStore = () => store;

export type dispatcher = typeof store.dispatch;

export const AppDispatch = () => useDispatch<dispatcher>();

export default getStore;