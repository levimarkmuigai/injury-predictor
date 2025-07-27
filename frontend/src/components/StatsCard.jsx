import React from 'react';

import {Card, CardContent} from '@/components/ui/card';

export default function StatCard(){
 const displayValue = loading ? '...' : error ? '!' : value ?? 0;
    return  (
        <Card className="stat-card">
            <CardContent className="stat-card_content">

                <h2 className="stat-card_title">{title}</h2>

                <p className="stat-card_value">{displayValue}</h2>
            </CardContent>
        </Card>
    );
}
