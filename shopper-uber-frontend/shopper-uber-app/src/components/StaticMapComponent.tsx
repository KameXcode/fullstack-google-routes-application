import { StaticMapProps } from "../interfaces/StaticMapProps"
export function StaticMapComponent({pointAlatitude, pointAlongitude, pointBlatitude, pointBlongitude}:StaticMapProps){
    const API_KEY = import.meta.env.VITE_API_KEY
    const url =  `https://maps.googleapis.com/maps/api/staticmap?size=600x300&markers=color:red%7Clabel:S%7C${pointAlatitude}, ${pointAlongitude}&markers=color:blue%7Clabel:S%7C${pointBlatitude}, ${pointBlongitude}&key=${API_KEY}`
    return(
    <div className="img-container">   
       <img src={url}></img>
    </div> 
    )
}