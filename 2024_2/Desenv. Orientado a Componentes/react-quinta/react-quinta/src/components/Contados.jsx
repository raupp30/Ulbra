import { useState } from 'react'

function Contador() {
    return (
        
    <div className="card">
        const [count, setCount] = useState(0)

        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
    )
}

export default Contador