import FormCadastro from "./components/forms/formsCadastro"
import Header from "./components/header/Header"
import Loc from "./components/loc/Loc"

function App() {

  return (
    <div>
      <Header />
      <Loc />
      <FormCadastro name="João" />
    </div>
  )
}

export default App
