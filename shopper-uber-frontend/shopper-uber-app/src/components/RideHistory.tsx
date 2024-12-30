import axios from "axios"
import { Input } from "./Input"
import "./rideHistory.css"
import { Ride } from "../interfaces/Rides"
import { useEffect, useState } from "react"
import { useSearchParams } from "react-router-dom"
import { useNavigate } from "react-router-dom"

export function RideHistory(){
    const navigate = useNavigate()
    const [driver, setDriver] = useState<string | null>()
    const [userId, setUserId] = useState("")
    const [searchParams] = useSearchParams();
    const [rides, setRides] = useState<Ride[]>()
    const fetchData = async(userId:string|null,driverId?:string|null,e?:React.FormEvent<HTMLFormElement>): Promise<void> => {
        e?.preventDefault();  
        const API_URL = driverId ? `http://localhost:8080/ride/${userId}?driver_id=${driverId}` : `http://localhost:8080/ride/${userId}`
        const response = await axios.get<Ride[]>(API_URL)
        setRides(response.data)
    }

    const OnChangeDriver = (e: React.ChangeEvent<HTMLSelectElement>) =>{
        setDriver(e.currentTarget.value === "0" ? null : e.currentTarget.value);
    }

    const OnChangeUserId = (e: React.ChangeEvent<HTMLInputElement>) => {
      setUserId(e.currentTarget.value)
    }
    const returnPageOnClick = () => {
        navigate("/")
    }

    useEffect(() => {
        const userId = searchParams.get("userId")
        fetchData(userId)
    }, [])


    return(
    <>
        <input type="button" value="<" className="return-button" onClick={() => returnPageOnClick()}/>
        <div className="ride-history-container">

            <form onSubmit={(e) => fetchData(userId,driver,e)} className="form-history-container">
                <div className="input-hcontainer">
                     <select  className="select-container" name="select" onChange={(e) => OnChangeDriver(e)}>
                        <option value="0">Sem filtro</option>
                        <option value="1">Homer Simpson</option>       
                        <option value="2">Dominic Torreto</option>
                        <option value="3">James Bond</option>
                    </select>
                    <input placeholder="Digite o ID do usuário desejado" onChange={(e) => OnChangeUserId(e)} value={userId} className="input-history"/>
                  
                    <button type="submit" className="search-button" >
                        <img src="https://png.pngtree.com/png-vector/20220706/ourlarge/pngtree-white-icon-of-a-magnifying-glass-or-loupe-vector-png-image_24988452.jpg" alt="" className="icon" />
                    </button>
                    
                </div>
            </form>
            <div className="ride-history">
                {rides && 
                rides?.map((ridesData) =>
                    <div className="ride-container">
                        <div className="ride-id" key={ridesData.ride_id}>
                            <label>ID DA CORRIDA</label>
                            {ridesData.ride_id}
                        </div>

                        <div className="ride-user-id">
                            <label>ID DO USUARIO</label>
                            {ridesData.customer_id}
                        </div>
                        <div className="ride-driver-name">
                            <label>Nome do motorista</label>
                            {ridesData.driver.nome}
                        </div>
                        <div className="ride-origin">
                            <label>Partida</label>
                            {ridesData.origin}
                        </div>
                        <div className="ride-destination">
                            <label>Destino</label>
                            {ridesData.destination}
                        </div>
                        <div className="ride-distance">
                             <label>Distancia</label>
                            {ridesData.distance}
                        </div>
                        <div className="ride-duration">
                             <label>Duração</label>
                            <span>{Math.floor(parseInt(ridesData.duration.slice(0, -1), 10)/60)}MIN</span>
                        </div>
                    </div>
                )}
            </div> 
        </div>  
    </>
        )
}  
        