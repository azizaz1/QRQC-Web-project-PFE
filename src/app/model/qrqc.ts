export class QRQC {
    id: number;
    nomPrenom: string;
    responsable: string;
    date: Date;
    produit: string;
    ref: string;
    tracabilite: string;
    problemDescription: string;
    quantiteisole: number;
    nbrPieceDefaut: number;
    niveau: string;
    quoi: string;
    qui: string;
    combien: string;
    quand: string;
    qu: string;
    comment: string;
    pourquoi: string;
    isolationEmplacement: string;
    isolationDetails: string;
    isolationDate: Date;
    isolationOuiNon: boolean;
    repassageEmplacement: string;
    repassageDetails: string;
    repassageDate: Date;
    repassageOuiNon: boolean;
    alerteProcessEmplacement: string;
    alerteProcessDetails: string;
    alerteProcessDate: Date;
    alerteProcessOuiNon: boolean;
    alerteMaintenanceEmplacement: string;
    alerteMaintenanceDetails: string;
    alerteMaintenanceDate: Date;
    alerteMaintenanceOuiNon: boolean;
    alerteFournisseurEmplacement: string;
    alerteFournisseurDetails: string;
    alerteFournisseurDate: Date;
    alerteFournisseurOuiNon: boolean;
    changementLotEmplacement: string;
    changementLotDetails: string;
    changementLotDate: Date;
    changementLotOuiNon: boolean;
    dtcOuvertEmplacement: string;
    dtcOuvertDetails: string;
    dtcOuvertDate: Date;
    dtcOuvertOuiNon: boolean;
    traitementAlerteDetails: string;
    traitementAlerteDate: Date;
    traitementAlerteDetails2: string;

    // Cause de non detection and cause de l'occurrence for P1 to P5
    p1CauseNonDetection: string;
    p1CauseOccurrence: string;
    p2CauseNonDetection: string;
    p2CauseOccurrence: string;
    p3CauseNonDetection: string;
    p3CauseOccurrence: string;
    p4CauseNonDetection: string;
    p4CauseOccurrence: string;
    p5CauseNonDetection: string;
    p5CauseOccurrence: string;

    // Additional attributes
    actions1: string;
    actions2: string;
    actions3: string;
    actions4: string;

    corrective1: string;
    corrective2: string;
    corrective3: string;
    corrective4: string;

    preventive1: string;
    preventive2: string;
    preventive3: string;
    preventive4: string;

    // Changing actionCloturee1 to a boolean type
    actionCloturee1: boolean;
    actionCloturee2: boolean;
    actionCloturee3: boolean;
    actionCloturee4: boolean;

    pilote1: string;
    pilote2: string;
    pilote3: string;
    pilote4: string;
    // New attributes with int type
    quantiteProduitAvant: number;
    quantiteDefectueuseAvant: number;
    quantiteProduitApres: number;
    quantiteDefectueuseApres: number;
    cloturisationPourcentage: string;

    // New attribute with checkbox
    qrqcNonCloture: boolean = false;
    qrqcNonEscalade: boolean = false;

    stageId: number;
}
