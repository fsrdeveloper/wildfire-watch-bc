import { Geometry } from "./geometry";
import { Properties } from "./properties";

export interface Feature {
    type: string;
    id: string;
    geometry: Geometry;
    geometry_name: string;
    properties: Properties;
}