CREATE TABLE drivers(
         id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
         nome VARCHAR(100) NOT NULL,
         descricao TEXT,
         carro VARCHAR(150) NOT NULL,
         avaliacao TEXT,
         taxa_km INTEGER NOT NULL,
         km_minimo INTEGER NOT NULL
);

INSERT INTO drivers(nome,descricao,carro,avaliacao,taxa_km,km_minimo)
VALUES (
   'Homer simpson',
   'Olá! Sou o Homer, seu motorista camarada! Relaxe e aproveite o passeio, com direito a rosquinhas e boas risadas (e talvez alguns desvios).',
   'Plymouth Valiant 1973 rosa e enferrujado',
   '2/5 Motorista simpático, mas errou o caminho 3 vezes. O carro cheira a donuts',
    250, 1),
   (
   'Dominic Toretto',
   'Ei, aqui é o Dom. Pode entrar, vou te levar com segurança e rapidez ao seu destino. Só não mexa no rádio, a playlist é sagrada.',
   'Dodge Charger R/T 1970 modificado',
   '4/5 Que viagem incrível! O carro é um show à parte e o motorista, apesar de ter uma cara de poucos amigos, foi super gente boa. Recomendo!',
   500,
   5
   ),
   (
   'James Bond',
   'Boa noite, sou James Bond. À seu dispor para um passeio suave e discreto. Aperte o cinto e aproveite a viagem.',
   'Aston Martin DB5 clássico',
   '5/5 Serviço impecável! O motorista é a própria definição de classe e o carro é simplesmente magnífico. Uma experiência digna de um agente secreto.',
    1000,
    10
);

CREATE TABLE rides(
    ride_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    customer_id INT NOT NULL,
    origin  TEXT NOT NULL,
    destination TEXT NOT NULL,
    distance BIGINT NOT NULL,
    duration TEXT NOT NULL,
    valor INTEGER,
    driver_id INT,FOREIGN KEY (driver_id) REFERENCES drivers(id)
);



