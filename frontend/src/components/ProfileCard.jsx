import  React   from    'react';

import  {   Link    }   from 'react-router-dom';

export  default function    ProfileCard({   profile })  {
    return  (
        <div className="p-4 border  rounded shadow-sm">
            <h2 className="font-bold    text-lg">
                {profile.firstName} {profile.lastName}
            </h2>
                <p>DOB: {new    Date(profile.dob).toLocalDateString()   }</p>
                <p>Gender:  {profile.gender}</p>
                <p>Height:  {profile.height} cm</p>
                <p>Weight:  {profile.weight} kg</p>
                <Link   to={`/profiles/${profile.id}`} className="text-blue-500">View Profile</Link>
        </div>

    );
}
