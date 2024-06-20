import Axios from 'axios';
import { APICONSTANTS } from '../apiConstants';

export const guess=async(guess:number)=>{
    console.log(process.env.NEXT_PUBLIC_URL)
    const res=await Axios.get(`${APICONSTANTS.GUESS}/${guess}`)
    return res;
}