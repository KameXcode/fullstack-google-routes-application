import { Option, ResponseEstimateData } from "./ResponseEstimateData";


export interface DriverOption extends Option{
    ride: ResponseEstimateData
    driver: Option
    userId: string
    origin: string
    destination: string


}