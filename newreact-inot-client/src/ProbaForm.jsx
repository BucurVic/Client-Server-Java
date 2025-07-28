
import React from  'react';
import { useState } from 'react';
import './ProbaForm.css'
export default function ProbaForm({addFunc, updateFunc}){

    const [id, setId] = useState('');
    const [distanta, setDistanta] = useState('');
    const [stil, setStil] = useState('');
    const [nrparticipantiinscrisi, setNrParticipantiInscrisi] = useState('');


    function handleSubmit (event){

        let proba={
            id:id,
            distanta:distanta,
            stil:stil,
            nrParticipantiInscrisi:nrparticipantiinscrisi
        }
        console.log('A Proba was submitted: ');
        console.log(proba);
        if (proba.id === "")
            addFunc(proba);
        else
            updateFunc(proba, proba.id);
        event.preventDefault();
    }
    return(
        <form onSubmit={handleSubmit} className="proba-form">
            <label>
                Id:
                <input type="number" value={id} onChange={e=>setId(e.target.value)} />
            </label><br/>
            <label>
                Distanta:
                <input type="text" value={distanta} onChange={e=>setDistanta(e.target.value)} />
            </label><br/>
            <label>
                Stil:
                <input type="text" value={stil} onChange={e=>setStil(e.target.value)} />
            </label><br/>
            <label>
                NrParticipantiInscrisi:
                <input type="number" value={nrparticipantiinscrisi}  onChange={e=>setNrParticipantiInscrisi(e.target.value)}  />
            </label><br/>

            <input type="submit" value="Add user" />
        </form>);
}
