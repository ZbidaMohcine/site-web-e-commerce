import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import Navbar from '../components/Navbar';
import { mobile } from "../Responsive";
import authService from '../sevices/authService';

const Container = styled.div`
    width: 100vw;
    height 92vh;
    background: linear-gradient(rgba(255,255,255,0.5),rgba(255,255,255,0.5)),
     url("https://img.freepik.com/free-photo/portrait-handsome-smiling-stylish-hipster-lambersexual-model-sexy-man-dressed-tshirt-jeans-fashion-male-isolated-blue-wall-studio_158538-26721.jpg?w=2000") center; 

     background-size: cover;
    display: flex;
    align-items: center;
    justify-content: center;
    `;

const Wrapper = styled.div`
   width: 40%;
   padding: 20px;
   background-color: white;
   border-radius: 20px;
   background: linear-gradient(
    rgba(255, 255, 255, 0.7),
    rgba(255, 255, 255, 0.7)
  );
   ${mobile({ width: "55%" })}
`;

const Form = styled.form`
    display: flex;
    flex-wrap: wrap;
`;

const Title = styled.h1`
    font-size: 24px;
    font-weight: 300;
`;

const Input = styled.input`
    flex: 1;
    min-width: 40%;
    margin: 20px 10px 0px 0px;
    padding: 10px;
    border-radius: 5px;
`;

const Agreement = styled.span`
    font-size: 12px;
    margin: 20px 0px;
`;

const Button = styled.button`
    width: 40%;
    border: none;
    padding: 15px 20px;
    background-color: teal;
    color: white;
    border-radius: 10px;
    cursor: pointer;
`;



const Register = () => {
    const [name, setName] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [confirm, setConfirm] = useState('');
    const [email, setEmail] = useState('');
    const [message, setMessage] = useState('');
    let navigate = useNavigate();


    const handleClick = (e) => {
        e.preventDefault();

        const credentials = { name, username, email, password };
        if (password === confirm) {
            authService.signup(credentials)
                .then(res => {
                    console.log(res.data);
                    navigate('/login')
                }).catch((err) => {
                    console.log(err.response.status);
                    navigate("/error");
                });
        } else {
            setMessage("les mots de past incompatible ");
            navigate('/register');

        }
    }
    return (
        <>
            <Navbar />
            <Container>
                <Wrapper>
                    <Title>CREATE AN ACCOUNT</Title>
                    <span style={{ color: "red" }}> {message} </span>
                    <Form>
                        <Input placeholder="name" value={name} onChange={(e) => setName(e.target.value)} />
                        {/* <Input placeholder = "Last name" /> */}
                        <Input placeholder="Username" value={username} onChange={(e) => setUsername(e.target.value)} />
                        <Input placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} />
                        <Input placeholder="Confirm Password" value={confirm} onChange={(e) => setConfirm(e.target.value)} />
                        <Input placeholder="email" value={email} onChange={(e) => setEmail(e.target.value)} />
                        <Agreement>
                            By creating an account, I consent to the processing of my personal data in accordance with the <b>PRIVAY POLICY</b>
                        </Agreement>

                        <Button onClick={handleClick}>CREATE</Button>

                    </Form>

                </Wrapper>
            </Container>

        </>
    )
}

export default Register
