
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import Form from './components/Form'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { RideHistory } from './components/RideHistory'



createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Form/>} />
      </Routes>
      <Routes>
        <Route path='/history' element={<RideHistory/>}/>
      </Routes>
    </BrowserRouter>
  </StrictMode>,
)
