export interface Ride{
    ride_id: number;
    customer_id: number;
    origin: string;
    destination: string;
    distance: number;
    duration: string;
    valor: number;
    driver: {
      driver_id: number;
      nome: string;
    };
  }
  