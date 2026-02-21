# HLD - AWS Data Ingestion & Log Analytics Pipeline

## Objective
Ingest multi-format data (CSV, Parquet, Text, Logs) through batch and streaming paths, standardize data, and provide secure/performant analytics.

## Ingestion Paths
1. **Batch file ingestion**
   - User/app uploads files to S3 Raw Zone (direct or API Gateway + Lambda validation)
2. **Streaming log ingestion**
   - Producers send logs/events to Kinesis Data Streams
   - Firehose delivers to S3 Raw Zone

## Storage & Data Zones
- **S3 Raw Zone:** immutable source payloads by source/date/type
- **S3 Curated Zone:** transformed/optimized Parquet for analytics
- Optional lifecycle to archive older data

## Processing
- Glue jobs normalize schemas, deduplicate, enrich, and convert to Parquet
- Glue Data Catalog stores schema metadata

## Analytics
- Athena for ad-hoc SQL over curated data
- OpenSearch optional for near-real-time log exploration
- QuickSight for business dashboards

## Security
- IAM least privilege
- KMS encryption for S3/Kinesis/Athena/Glue
- Lake Formation governance on datasets
- CloudTrail for audit trails

## Reliability & Operations
- CloudWatch alarms on ingestion lag, job failures, query errors
- DLQ/retry strategy for failed validations or stream transforms
- Partitioning strategy by date/source/app for cost-efficient queries

## Diagram Artifact
- `examples/data-ingestion-pipeline-aws.drawio`
