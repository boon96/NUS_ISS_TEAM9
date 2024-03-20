import axios from "axios";
import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";


const initialState ={
    activationSuccess: false,
    activationFailure: false,
}

export type HomeState = Readonly<typeof initialState>;

export const testlogin = createAsyncThunk(
    'home/login',
    async(loginInfo: any) =>{
        try{
            return(await axios.post('api/customer',loginInfo,{
                headers:{
                    "Content-Type": "application/json",
                },
            })
            // return response;
            )
        }catch(error){
            throw error;
        }
    }
)

export const HomeStateSlice = createSlice({
    name: 'home-login',
    initialState: initialState as HomeState,
    reducers:{
        reset() {
            return initialState;
        },
    },
    extraReducers(builder){
        builder
        .addCase(testlogin.pending, () => initialState)
        .addCase(testlogin.rejected, state => {
            state.activationFailure = true;
        })
        .addCase(testlogin.fulfilled, state => {
            state.activationSuccess = true;
        });
    },
});
export const {reset} = HomeStateSlice.actions;

export default HomeStateSlice.reducer;