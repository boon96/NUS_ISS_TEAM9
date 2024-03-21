import axios from "axios";
import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";


const initialState ={
    activationSuccess: false,
    activationFailure: false,
}

export type HotelState = Readonly<typeof initialState>;

export const roomSearch = createAsyncThunk(
    'hotel/booking',
    async(Form: any) =>{
        try{
            console.log(Form);
            return(await axios.post('api/room',Form,{
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

export const HotelStateSlice = createSlice({
    name: 'hotel-search',
    initialState: initialState as HotelState,
    reducers:{
        reset() {
            return initialState;
        },
    },
    extraReducers(builder){
        builder
        .addCase(roomSearch.pending, () => initialState)
        .addCase(roomSearch.rejected, state => {
            state.activationFailure = true;
        })
        .addCase(roomSearch.fulfilled, state => {
            state.activationSuccess = true;
        });
    },
});
export const {reset} = HotelStateSlice.actions;

export default HotelStateSlice.reducer;