# HLD (V2)

## Layers
- Ingestion: S3/API/Lambda, Kinesis/Firehose
- Processing: Glue ETL
- Storage: S3 Raw + Curated
- Metadata: Glue Catalog
- Analytics: Athena + QuickSight
- Ops/Sec: CloudWatch, CloudTrail, IAM, KMS

## Core Flow
Sources -> Ingestion -> Raw S3 -> Glue -> Curated S3 -> Athena -> QuickSight
