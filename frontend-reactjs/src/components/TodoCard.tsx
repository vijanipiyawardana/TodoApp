import { TodoType } from "./Todo"
import Card from "react-bootstrap/Card";

type TodoCardProps = {
    todoItem: TodoType;
}

export const TodoCard = (props: TodoCardProps) => {

  return (

    <Card>
      <Card.Body>
        <Card.Header>{props.todoItem.id}</Card.Header>
        <Card.Title>{props.todoItem.title}</Card.Title>
        <Card.Text>{props.todoItem.addedDate}</Card.Text>
        <Card.Text>{props.todoItem.status}</Card.Text>
      </Card.Body>
    </Card>

  )
}
