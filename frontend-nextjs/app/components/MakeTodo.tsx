"use client"
import axios from "axios"
import { useState } from "react";
import { Form, Button, InputGroup, FormControl } from "react-bootstrap";


export const MakeTodo = () => {
    const [title, setTitle] = useState("");

    const handleAddTodo = () => {
        
    }

    return (
        <div>
            <Form>
                <Form.Group>
                    <Form.Label>Title</Form.Label>
                    <InputGroup>
                        <FormControl
                            type="text"
                            value={title}
                            onChange={(e) => setTitle(e.target.value)}
                        />
                    </InputGroup>
                </Form.Group>
                <Button variant="primary" onClick={handleAddTodo}>
                    Submit
                </Button>
            </Form>
        </div>
    )
}
