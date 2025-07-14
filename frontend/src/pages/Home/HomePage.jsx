import  React,  {   useState,   useEffect   }   from    'react';

import  {   fetchProfileById,   createProfile   }   from    '../../api/athlete';

import  ProfileCard from    '../../components/ProfileCard';

export  default function    HomePage()  {
    
    const   [profile,setProfiles]  =   useState([]);

    const   [form, setForm] =   useState({
        firstName:  '', lastName:   '', dob:    '', gender: '',
        weight: '', height: ''
    });

    useEffect   (() =>  {
        fetchProfileById().then(setProfiles);
    },  []);

    const   handleChange    =   (e) =>  {
        setForm(prev    =>  ({  ...prev,    [e.target.name]:    e.target.value  }));
    };

    const   handleSubmit    =   async   (e) =>  {
        e.preventDefault();
        const   newProfile  =   await   createProfile(form);
        setProfiles(prev    =>  [...prev,    newProfile]);
        setForm({   firstName:  '', lastName:   '', dob:    '', gender: '',
        weight: '', height: ''});
    };

    return  (
        <div className="max-w-3xl   mx-auto p-4 space-y-6">
            <h1 className="text-2xl font-bold">Athlete Registry</h1>
            
            <form onSubmit= {handleSubmit}  className="space-y-2">
                <input  type="text" name="firstName"    placeholder="First Name"    value={form.firstName}  onChange={handleChange} required    />
                <input  type="text" name="lastName"    placeholder="Last Name"   value={form.lastName}  onChange={handleChange} required    />
                <input  type="date" name="dob"  placeholder="Date of birth"    value={form.dob}  onChange={handleChange} required    />
                <input  type="gender" name="text"  placeholder="Gender"    value={form.gender}  onChange={handleChange} required    />
                <input  type="number" name="weight"  placeholder="Weight (kg)"    value={form.weight}  onChange={handleChange} required    />
                <input  type="number" name="height"  placeholder="Height    (cm)"    value={form.height}  onChange={handleChange} required    />

                <button type="submit">Add Athlete</button>
            </form>

            <div className="grip gap-4">
                {profile.map(profile    =>  (
                        <ProfileCard key={profile.id}   profile={profile}   />
                    ))}
            </div>
        </div>
    );
}
