export class Stage {
  id: number;
  nom_entreprise: string;
  titreStage: string;
  description: string;
  dateIncident: string | number | Date;
  lieuIncident: string;
  equipementComposant: string;
  dommagesMateriels: string;
  graviteIncident: string;
  facteursContributifs: string;
  actionCorrective: string;
  userId: number; // User ID associated with the stage
  imageRapport : string;
}
