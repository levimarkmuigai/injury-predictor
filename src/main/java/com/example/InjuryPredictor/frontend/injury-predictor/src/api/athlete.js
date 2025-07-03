const API_BASE = process.env.REACT_APP_API || 'https://localhost:8080/api';

export async function fetchProfileById(id){
    const resp = await fetch(`${API_BASE}/profiles/${id}`);
    if(!resp.ok) throw new Error(`HTTP ${resp.status}`);

    return resp.json;
}
