# LLD - Low-Level Design

## 1. Ingestion Modules
### 1.1 Batch Ingestion
- Source uploads to `s3://<bucket>/raw/<domain>/<date>/...`
- Validation Lambda (optional) writes manifest + rejects invalid payloads

### 1.2 Streaming Ingestion
- Producers publish to Kinesis Data Streams
- Firehose delivers batched/compressed records to raw S3 prefixes

## 2. Processing Modules (Glue)
- Job A: schema normalization
- Job B: enrichment + deduplication
- Job C: Parquet conversion + partitioning
- Job outputs to `s3://<bucket>/curated/<domain>/...`

## 3. Catalog + Query
- Glue crawlers/explicit schema registration
- Athena workgroups with query limits and output location

## 4. Security Controls (Implementation)
- IAM roles per job/service
- KMS CMKs on S3 buckets and integrated services
- Bucket policies restricting non-TLS and public access

## 5. Failure Handling
- DLQ for failed validation and transform events
- Retry policy: exponential backoff for transient failures
- Dead-letter triage workflow and replay tool/process

## 6. Observability Points
- CloudWatch metrics: ingest lag, job duration, failure count
- CloudWatch alarms + SNS notifications
- CloudTrail for API-level audit events

## 7. Open Technical Decisions
- Exact partition strategy by domain and query patterns
- Real-time analytics need for OpenSearch in phase 1
- Data retention + archival policy thresholds
