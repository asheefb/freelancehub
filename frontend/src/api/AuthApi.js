import axios from "axios";
import { API_LOCAL_URL } from "../constants/AppConstant";



export const registerUser = async (userData) => {
    try {
        const response = await axios.post(`${API_LOCAL_URL}auth/register`, userData, {
            headers: {
                "Content-Type": "application/json",
            },
        });
        console.log("User registered successfully:", response.data);
        return response.data;
    }
    catch (error) {
        console.error("Error registering user:", error);
        console.log(error.response?.data?.statusCode);
        throw new Error(
            error.response?.data.statusCode || "An error occurred during registration."
        );
    }
}

export const loginUser = async (userData) => {
    try {
        const response = await axios.post(`${API_LOCAL_URL}auth/login`, userData, {
            headers: {
                "Content-Type": "application/json",
            },
        });
        return response.data;
    }
    catch (error) {
        console.error("Error logging in user:", error);
        throw new Error(
            error.response?.data?.message || "An error occurred during login."
        );
    }
}   