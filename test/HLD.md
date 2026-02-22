# HLD - High-Level Design

## 1. Logical Architecture
- Producers (files + event sources)
- Ingestion Layer (S3, Kinesis, optional API Gateway/Lambda)
- Processing Layer (Glue ETL)
- Storage Layer (Raw/Curated S3 zones)
- Metadata Layer (Glue Catalog)
- Analytics Layer (Athena/QuickSight, optional OpenSearch)
- Ops/Security Layer (CloudWatch, CloudTrail, IAM, KMS, Lake Formation)

## 2. Primary Data Flows
1. Batch files -> S3 Raw
2. Events/logs -> Kinesis -> Firehose -> S3 Raw
3. Glue ETL -> Curated S3 + Catalog updates
4. Athena queries curated datasets
5. QuickSight dashboards consume Athena datasets

## 3. Reliability Design
- Retry + DLQ on ingestion/processing errors
- Pipeline health alarms and runbook links
- Idempotent processing and checkpointing

## 4. Security Design
- IAM least privilege for each pipeline stage
- KMS encryption for data/services
- Lake Formation policy controls on curated datasets

## 5. Deployment Notes
- Multi-environment setup: dev/test/prod
- Infrastructure as code recommended
- Tagged resources for cost allocation
