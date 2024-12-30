import { useState } from "react";
import { EstimateData } from "../interfaces/EstimateData.ts";
import axios from "axios";
import { ResponseEstimateData, Option } from "../interfaces/ResponseEstimateData.ts";
import { Input } from "./Input.tsx";
import "./form.css"
import { StaticMapComponent } from "./StaticMapComponent.tsx";
import { ConfirmData } from "../interfaces/ConfirmData.ts";
import { DriverOption } from "../interfaces/DriverOption.ts";
import { useNavigate } from "react-router-dom";

export function Form() {
  
  const [userId, setUserId] = useState("");
  const [origin, setOrigin] = useState("");
  const [destination, setDestination] = useState("");
  const [estimateDataResponse, setEstimateDataResponse] = useState<ResponseEstimateData>();
  const [responseNotFound, setResponseNotFound] = useState("");
  const API_URL = "http://localhost:8080/ride/estimate";
  const postData = async (e: React.FormEvent<HTMLFormElement>): Promise<ResponseEstimateData | undefined>  =>       {
    e?.preventDefault() 
    setResponseNotFound("") 
    const requestBody: EstimateData = {
      origin,
      destination
    };
    try{
        const response = await axios.post<ResponseEstimateData>(
        API_URL,
        requestBody
        );
        setEstimateDataResponse(response.data)
        return response.data;
    }
    catch(error){
        if (axios.isAxiosError(error) && error.response?.status === 404){
            setResponseNotFound(error.response.data);
            return error.response.data
        }
    }
                
  };

 


  const onChangeUserId = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = e.currentTarget.value
    setUserId(value)
  } 
  const onChangeOrigin = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = e.currentTarget.value
    setOrigin(value)
  } 
  const onChangeDestination = (e: React.ChangeEvent<HTMLInputElement>) => {
    const value = e.currentTarget.value
    setDestination(value)
  } 
  return (
    <div className="estimate-page-container">
      
      <form onSubmit={(e) => postData(e)} className="form-container">
        <div className="input-container">
            <Input label="Id do usuario" type= "number" value={userId} onChange={(e) => onChangeUserId(e)}/>
            <Input
            label="Local de partida"
            value={origin}
            onChange={(e) => onChangeOrigin(e)}/>
            <Input
            label="Local de saida"
            value={destination}
            onChange={(e) => onChangeDestination(e)}
            ></Input>
        </div>
        <button id="form-button" type="submit" >Enviar</button>
      </form>
      {estimateDataResponse && <StaticMapComponent pointAlatitude={estimateDataResponse.startLocation.latitude}
         pointAlongitude={estimateDataResponse.startLocation.longitude} 
         pointBlatitude={estimateDataResponse.endLocation.latitude}
         pointBlongitude={estimateDataResponse.endLocation.longitude}/>}
      <div className="driver-options">
      
        {estimateDataResponse && 
        estimateDataResponse?.options.map((responseData) =>
        <>
          <DriverOptions 
          nome = {responseData.nome} 
          descricao={responseData.descricao} 
          avaliacao={responseData.avaliacao} 
          carro={responseData.carro}   
          valor={responseData.valor}
          id={responseData.id}  
          ride={estimateDataResponse}
          userId={userId}
          origin={origin}
          destination={destination}
          />
        </>
        )}
        {responseNotFound && <h1>{responseNotFound}</h1>}
       </div>
    </div>
  );
}




export function DriverOptions({nome, descricao ,avaliacao, carro, valor, id, ride, userId, origin, destination}: DriverOption) {
  const navigate = useNavigate()
  const handleOnClickDriverOption = async (ride: ResponseEstimateData , id: number, valor:number , userId: number, origin: string, destination: string): Promise<void>  => {
    const confirmDataBodyRequest: ConfirmData = {
      customer: userId,
      origin: origin,
      destination: destination,
      distance: ride.distanceMeters,
      driver_id: id,
      duration: ride.duration,
      valor: valor
    }
    try{
      await axios.post("http://localhost:8080/ride/confirm", confirmDataBodyRequest);
        console.log("Corrida confirmada com sucesso")
        navigate(`/history?userId=${userId}`)
        return undefined;
      
  }
    catch(e){
      console.log("Ocorreu um erro na hora de confirmar a corrida")
      console.error(e)
      return undefined;
    }
  }
  
        return (
    <>
        <div className="driver">
            <div id="nome">{nome}</div>
            <div id="informações">
                <div id="description">{descricao}</div>
                <div id="rating">{avaliacao}</div>
                <div id="car">{carro}</div>
                <div id="value">R${valor/100}
                <input id="infobutton" type="button" value="Escolher" onClick={() => handleOnClickDriverOption(ride,id,valor,parseInt(userId),origin,destination)}/>  
                </div> 
            </div>
        </div>
    </>
        );
    }
    export default Form;
