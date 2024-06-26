import axios from "axios";
import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";


const initialState = {
    activationSuccess: false,
    activationFailure: false,
}

export type HotelState = Readonly<typeof initialState>;

export const roomSearch = createAsyncThunk(
    'hotel/booking',
    async (Form: any) => {
        try {
            console.log(Form);
            return (await axios.get('api/room')
            )
        } catch (error) {
            throw error;
        }
    }
)

export const reservationBooking = createAsyncThunk(
    'reservation/booking',
    async (reservationForm: any) => {
        try {
            console.log(reservationForm);
            return (await axios.post('api/booking', reservationForm, {
                headers: {
                    "Content-Type": "application/json",
                },
            })
            )
        } catch (error) {
            throw error;
        }
    }
)

export const searchBooking = createAsyncThunk(
    'search/booking',
    async (searchId: any) => {
        try {
            console.log(searchId);
            return (await axios.get('api/booking/' + searchId
            )
            )
        } catch (error) {
            throw error;
        }
    }
)

export const deleteBooking = createAsyncThunk(
    'delete/booking',
    async (bookingId: any) => {
        try {
            console.log(bookingId);
            return (await axios.delete('api/booking/' + bookingId
            )
            )
        } catch (error) {
            throw error;
        }
    }
)

export const HotelStateSlice = createSlice({
    name: 'hotel-search',
    initialState: initialState as HotelState,
    reducers: {
        reset() {
            return initialState;
        },
    },
    extraReducers(builder) {
        builder
            .addCase(roomSearch.pending, () => initialState)
            .addCase(roomSearch.rejected, state => {
                state.activationFailure = true;
            })
            .addCase(roomSearch.fulfilled, state => {
                state.activationSuccess = true;
            })
            .addCase(reservationBooking.pending, () => initialState)
            .addCase(reservationBooking.rejected, state => {
                state.activationFailure = true;
            })
            .addCase(reservationBooking.fulfilled, state => {
                state.activationSuccess = true;
            })
            .addCase(searchBooking.pending, () => initialState)
            .addCase(searchBooking.rejected, state => {
                state.activationFailure = true;
            })
            .addCase(searchBooking.fulfilled, state => {
                state.activationSuccess = true;
            })
            .addCase(deleteBooking.pending, () => initialState)
            .addCase(deleteBooking.rejected, state => {
                state.activationFailure = true;
            })
            .addCase(deleteBooking.fulfilled, state => {
                state.activationSuccess = true;
            });
    },
});
export const { reset } = HotelStateSlice.actions;

export default HotelStateSlice.reducer;