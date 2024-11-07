package main

import "document"
type Document struct {
    BoilingPoint document.BoilingPoint `json:"boiling_point"`
    Dangerous bool `json:"dangerous"`
    Density document.Density `json:"density"`
    Name string `json:"name"`
    Type string `json:"type"`
    
}
