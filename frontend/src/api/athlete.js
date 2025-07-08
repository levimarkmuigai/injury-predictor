const API_BASE = 'http://localhost:8080/api';

export async function fetchProfileById(id){
    const resp = await fetch(`${API_BASE}/profiles/${id}`);
    if(!resp.ok) throw new Error(`HTTP ${resp.status}`);

    return resp.json();
}

export  async   function    createProfile(data) {
    const res   =   await   fetch(`${API_BASE}/profiles`,   {
        method: 'POST',
        headers:    {   'Content-Type': 'application/json'  },
        body:   JSON.stringify(data)
    });
    if (!res.ok)    throw   new Error('Create   failed');
    return  res.json();
}
