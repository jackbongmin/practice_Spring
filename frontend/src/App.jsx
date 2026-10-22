import { useEffect, useState } from 'react'

function App() {
    const [message, setMessage] = useState('')

    useEffect(() => {
        fetch('http://localhost:8080/day02/hello')
            .then((response) => response.text())    // 응답이 JSON이 아니라 '글자'이므로 text()
            .then((text) => setMessage(text))
            .catch((error) => console.error('Error fetching data:', error))
    }, [])

    return <div>{message||'응답 대기 중. . .'}</div>
}

export default App