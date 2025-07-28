
import React from  'react';
import './ProbaTable.css'

function ProbaRow({proba, deleteFunc}){
    function handleDelete(){
        console.log('delete button pentru '+proba.id);
        deleteFunc(proba.id);
    }
    return (
        <tr>
            <td>{proba.id}</td>
            <td>{proba.distanta}</td>
            <td>{proba.stil}</td>
            <td>{proba.nrParticipantiInscrisi}</td>
            <td><button onClick={handleDelete}>Delete</button></td>
        </tr>
    );
}


export default function ProbaTable({probeList, deleteFunc}){
    console.log("In ProbaTable");
    console.log(probeList);
    let rows = [];
    let functieStergere=deleteFunc;
    probeList.forEach(function(proba) {
        // console.log(proba.nrParticipantiInscrisi)
        rows.push(<ProbaRow proba={proba} key={proba.id} deleteFunc={functieStergere} />);
    });


    return (
        <div className="ProbaTable">
            <table className="center">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Distanta</th>
                    <th>Stil</th>
                    <th>NrParticipantiInscrisi</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>{rows}</tbody>
            </table>

        </div>
    );
}

