import React, {useEffect} from  'react';
import { useState } from 'react';
import ProbaTable from './ProbaTable.jsx';
import './App.css'
import ProbaForm from "./ProbaForm.jsx";
import {GetProbe, AddProba, DeleteProba, UpdateProba} from './utils/rest-calls'


export default function App(){
    const [probe, setProbe] = useState([{"id":23, "distanta":"400m", "stil":"fluture", "nrparticipantiinscrisi":50}]);

    function addFunc(proba){
        console.log('inside addFunc '+proba);
        AddProba(proba)
            .then(()=> GetProbe())
            .then(probe=>setProbe(probe))
            .catch(erorr=>console.log('eroare add ',erorr));
    }

    function deleteFunc(id){
        console.log('inside deleteFunc '+id);
        DeleteProba(id)
            .then(()=> GetProbe())
            .then(probe=>setProbe(probe))
            .catch(error=>console.log('eroare delete', error));
    }

    function updateFunc(proba, id){
        console.log('inside updateFunc '+proba);
        UpdateProba(proba, id)
            .then(()=> GetProbe())
            .then(probe=>setProbe(probe))
            .catch(error=>console.log('eroare update', error));
    }

    useEffect(()=>{
        console.log('inside useEffect')
        GetProbe().then(probe=>setProbe(probe));},[]);

    return (<div className="App">
        <h1>New Probe Management App </h1>
        <ProbaForm addFunc={addFunc} updateFunc={updateFunc}/>
        <br/>
        <br/>
        <ProbaTable probeList={probe} deleteFunc={deleteFunc}/>
    </div>);
}

