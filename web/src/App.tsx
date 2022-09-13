interface ButtonProps {
  title: string;
}

function Button(props: ButtonProps) {
  return (
    <>
      <button>{props.title}</button>
    </>
  )
}

function App() {
  return (
    <>
      <Button title="Good bye" />
      <Button title="Hello there" />
      <Button title="Hello world" />
      <Button title="Bye bye" />
    </>
  )
}

export default App
