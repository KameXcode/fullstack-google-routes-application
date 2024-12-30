  export interface ResponseEstimateData {
      client_id?: number;
      distanceMeters: number;
      duration: string;
      startLocation: Location;
      endLocation: Location;
      options: Option[];
    }
    
   interface Location {
      latitude: string;
      longitude: string;
    }
    
    export interface Option {
      id: number;
      nome: string;
      descricao: string;
      carro: string;
      avaliacao: string;
      taxa_km: number;
      km_minimo: number;
      valor: number;
       
    }