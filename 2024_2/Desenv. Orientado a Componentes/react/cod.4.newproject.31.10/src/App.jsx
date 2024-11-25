import { BrowserRouter, Route, Routes } from "react-router-dom"
import Home from "./Pages/Home"
import Sobre from "./Pages/Sobre"
import PageNotFound from "./Pages/PageNotFound"
import Contato from "./Pages/Contato"

const App = () => {

  return (
      <BrowserRouter>
      <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/contato" element={<Contato />} />
      <Route path="/sobre" element={<Sobre />} />
      <Route path="/*" element={<PageNotFound />} />
      </Routes>
      </BrowserRouter>

  
  )
}

export default App
