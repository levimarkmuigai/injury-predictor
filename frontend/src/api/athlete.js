const REACT_APP_API_BASE = 'http://localhost:8080/api';

export async function fetchProfileById(id){
    const resp = await fetch(`${REACT_APP_API_BASE}/profiles/${id}`);
    if(!resp.ok) throw new Error(`HTTP ${resp.status}`);

    return resp.json();
}
